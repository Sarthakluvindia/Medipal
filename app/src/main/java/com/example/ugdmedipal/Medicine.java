package com.example.ugdmedipal;

public class Medicine {
    String disease;
    String MedicineId;

    public Medicine() {
    }

    public Medicine(String MedicineId, String disease) {
        this.disease = disease;
        this.MedicineId = MedicineId;
    }

    public String getDisease() {
        return disease;
    }

    public String getMedicineId() {
        return MedicineId;
    }
}
