import torch.nn as nn
from torchvision import models

class Net(nn.Module):
    def __init__(self):
        super(Net, self).__init__()
        # Carrega o modelo ResNet18 sem pesos pré-treinados (eles foram treinados por você)
        self.model = models.resnet18(pretrained=False)
        
        # Substitui a camada final para ajustar ao número de classes do seu problema
        num_ftrs = self.model.fc.in_features
        self.model.fc = nn.Linear(num_ftrs, 2)  # 2 classes: NORMAL e PNEUMONIA

    def forward(self, x):
        return self.model(x)
