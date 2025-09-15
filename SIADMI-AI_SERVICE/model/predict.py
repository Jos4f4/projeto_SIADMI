# model/predict.py

import torch
from torchvision import transforms, models
from PIL import Image
import io
import torch.nn as nn

# Quantidade de classes no seu problema
NUM_CLASSES = 2  # NORMAL/PNEUMONIA

# Rebuild the model with the architecture used in training
model = models.resnet18(weights=None)
model.fc = nn.Linear(model.fc.in_features, NUM_CLASSES)

# Load the saved weights
model.load_state_dict(torch.load("model/model.pt", map_location=torch.device("cpu")))

# Put in inference mode
model.eval()

# Transformations used in training
transform = transforms.Compose([
    transforms.Resize((224, 224)),
    transforms.ToTensor(),
    transforms.Normalize([0.485, 0.456, 0.406], [0.229, 0.224, 0.225])
])

# List class
classes = ['NORMAL', 'PNEUMONIA'] 

# Function of prediction
async def predict_image(file):
    image_bytes = await file.read()
    image = Image.open(io.BytesIO(image_bytes)).convert("RGB")
    input_tensor = transform(image).unsqueeze(0)

    with torch.no_grad():
        outputs = model(input_tensor)
        probabilities = torch.nn.functional.softmax(outputs[0], dim=0)
        confidence, predicted_class = torch.max(probabilities, 0)

    return {
        "prediction": classes[predicted_class.item()],
        "confidence": round(confidence.item(), 4)
    }
