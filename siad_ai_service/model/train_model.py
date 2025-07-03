# train_model.py

import os
import torch
import torchvision
import torch.nn as nn
import torch.optim as optim  # corrigido aqui
from torchvision import transforms, datasets, models
from torch.utils.data import DataLoader

# Diretórios do dataset (baixado do Kaggle Chest X-Ray Pneumonia)
DATA_DIR = "chest_xray"
TRAIN_DIR = os.path.join(DATA_DIR, "train")
VAL_DIR = os.path.join(DATA_DIR, "val")
TEST_DIR = os.path.join(DATA_DIR, "test")

# Transformacoes para pre-processar imagens
transform = transforms.Compose([
    transforms.Resize((224, 224)),
    transforms.ToTensor(),
    transforms.Normalize([0.485, 0.456, 0.406], [0.229, 0.224, 0.225])
])

# Datasets e DataLoaders
train_dataset = datasets.ImageFolder(TRAIN_DIR, transform=transform)
val_dataset = datasets.ImageFolder(VAL_DIR, transform=transform)
test_dataset = datasets.ImageFolder(TEST_DIR, transform=transform)

train_loader = DataLoader(train_dataset, batch_size=32, shuffle=True)
val_loader = DataLoader(val_dataset, batch_size=32, shuffle=False)

# Modelo base: ResNet18
model = models.resnet18(pretrained=True)
num_features = model.fc.in_features
model.fc = nn.Linear(num_features, 2)  # pneumonia vs normal

# Treinamento
criterion = nn.CrossEntropyLoss()
optimizer = optim.Adam(model.parameters(), lr=1e-4)  # corrigido aqui
device = torch.device("cuda" if torch.cuda.is_available() else "cpu")
model = model.to(device)

NUM_EPOCHS = 5

for epoch in range(NUM_EPOCHS):
    model.train()
    running_loss = 0.0
    for images, labels in train_loader:
        images, labels = images.to(device), labels.to(device)
        optimizer.zero_grad()
        outputs = model(images)
        loss = criterion(outputs, labels)
        loss.backward()
        optimizer.step()
        running_loss += loss.item()

    print(f"Epoch {epoch+1}/{NUM_EPOCHS} - Loss: {running_loss/len(train_loader):.4f}")

# Salvar o modelo
os.makedirs("model", exist_ok=True)
torch.save(model.state_dict(), "model/model.pt")
print("Modelo salvo em model/model.pt")
