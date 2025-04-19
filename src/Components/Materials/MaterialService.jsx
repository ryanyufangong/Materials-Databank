// src/services/materialService.js

import Material from "./Material";

const API_URL = "http://localhost:8000/material/getMaterialsFromMaterialTypeID";

export const fetchMaterialsByType = async (materialTypeId) => {
    try {
        const response = await fetch(API_URL, {
            method: "POST",
            headers: { "Content-Type": "application/json" },
            body: JSON.stringify({ material_type_id: parseInt(materialTypeId) })
        });

        if (!response.ok) throw new Error("Failed to fetch materials");

        const data = await response.json();
        return data.map((item) => new Material(item.id, item.name));
    } catch (error) {
        console.error("Error fetching materials:", error);
        return [];
    }
};
