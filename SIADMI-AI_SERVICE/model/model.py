import torch.nn as nn
from torchvision import models

#This class is only for show be of the ResNet

class Net(nn.Module):
    def __init__(self):
        super(Net, self).__init__()

        # Loads the ResNet18 model without pre-trained weights
        self.model = models.resnet18(pretrained=False)
        
        # Replaced final camade for adjust of class numbers  for your problem.
        num_ftrs = self.model.fc.in_features
        self.model.fc = nn.Linear(num_ftrs, 2)  # 2 class: NORMAL or PNEUMONIA

    def forward(self, x):
        return self.model(x)
