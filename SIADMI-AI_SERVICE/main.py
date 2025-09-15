# main.py
from fastapi import FastAPI, File, UploadFile
from fastapi.middleware.cors import CORSMiddleware
from model.predict import predict_image

app = FastAPI()

# Requisitions of Java + Spring Boot
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Java + Spring Boot address permition to acess this service
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.post("/predict")
async def upload_image(file: UploadFile = File(...)):
    result = await predict_image(file)
    return result
