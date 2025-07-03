# main.py
from fastapi import FastAPI, File, UploadFile
from fastapi.middleware.cors import CORSMiddleware
from model.predict import predict_image

app = FastAPI()

# Permitir requisições do backend Java
app.add_middleware(
    CORSMiddleware,
    allow_origins=["*"],  # Coloque o endereço exato do frontend/backend se necessário
    allow_credentials=True,
    allow_methods=["*"],
    allow_headers=["*"],
)

@app.post("/predict")
async def upload_image(file: UploadFile = File(...)):
    result = await predict_image(file)
    return result
