import { useState, useEffect } from "react";
import { fetchMaterialsByType } from "./MaterialService";

const MaterialTable = ({ materialTypeId }) => {
    const [materials, setMaterials] = useState([]);

    const [columns] = useState([
        { key: "id", label: "ID" },
        { key: "name", label: "Material Name" }
    ]);

    useEffect(() => {
        console.log("MaterialTable received materialTypeId:", materialTypeId);
        // if (materialTypeId) {
        //     fetchMaterialsByType(materialTypeId).then(setMaterials);
        // }
        if (materialTypeId) {
            fetchMaterialsByType(materialTypeId).then(data => {
                console.log("Fetched materials:", data);
                setMaterials(data);
            });
        }
    }, [materialTypeId]);

    return (
        <div>
            <h2>Materials for Type ID: {materialTypeId}</h2>
            <table border="1">
                <thead>
                <tr>{columns.map((col) => <th key={col.key}>{col.label}</th>)}</tr>
                </thead>
                <tbody>
                {materials.length > 0 ? (
                    materials.map((material) => (
                        <tr key={material.id}>
                            {columns.map((col) => <td key={col.key}>{material[col.key]}</td>)}
                        </tr>
                    ))
                ) : (
                    <tr><td colSpan={columns.length}>No materials found</td></tr>
                )}
                </tbody>
            </table>
        </div>
    );
};

export default MaterialTable;
