import { useState, useEffect } from "react";
import { fetchMaterialsByType } from "./MaterialService";

const MaterialTable = ({ materialTypeId }) => {
    const [materials, setMaterials] = useState([]);

    const columns = [
        { key: "id", label: "ID" },
        { key: "name", label: "Material Name" }
    ];

    useEffect(() => {
        console.log("MaterialTable received materialTypeId:", materialTypeId);

        if (materialTypeId) {
            fetchMaterialsByType(materialTypeId).then(data => {
                console.log("Fetched materials:", data);
                setMaterials(data);
            });
        } else {
            setMaterials([]); // Clear table if no materialTypeId is set
        }
    }, [materialTypeId]);

    return (
        <div style={{ marginTop: "20px", color: "black" }}>
            <h2 style={{ color: "black" }}>Materials for Type ID: {materialTypeId || "None Selected"}</h2>

            <table style={{ width: "100%", borderCollapse: "collapse", marginTop: "10px", color: "black" }}>
                <thead>
                <tr style={{ backgroundColor: "#ddd", color: "black" }}>
                    {columns.map((col) => (
                        <th key={col.key} style={{ border: "1px solid black", padding: "8px", color: "black" }}>
                            {col.label}
                        </th>
                    ))}
                </tr>
                </thead>
                <tbody>
                {materials.length > 0 ? (
                    materials.map((material) => (
                        <tr key={material.id} style={{ backgroundColor: "#f9f9f9", color: "black" }}>
                            {columns.map((col) => (
                                <td key={col.key} style={{ border: "1px solid black", padding: "8px", color: "black" }}>
                                    {material[col.key]}
                                </td>
                            ))}
                        </tr>
                    ))
                ) : (
                    <tr>
                        <td colSpan={columns.length} style={{ textAlign: "center", padding: "8px", color: "black" }}>
                            No materials found
                        </td>
                    </tr>
                )}
                </tbody>
            </table>
        </div>
    );
};

export default MaterialTable;
