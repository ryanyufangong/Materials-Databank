// import React, { useEffect, useState } from "react";
// import "./MaterialTable.css"; // External CSS file for styling
//
// const NichromeAlloys = ({ selectedMaterial }) => {
//     const [data, setData] = useState([]);
//
//     useEffect(() => {
//         if (selectedMaterial) {
//             fetch(`http://localhost:8000/api/materials`, {
//                 method: "POST",
//                 headers: { "Content-Type": "application/json" },
//                 body: JSON.stringify({ materialName: selectedMaterial })
//             })
//                 .then(response => response.json())
//                 .then(data => {
//                     setData(data);
//                 })
//                 .catch(error => console.error("Error fetching material data:", error));
//         }
//     }, [selectedMaterial]);
//
//     return (
//         <div className="table-container">
//             <h2>{selectedMaterial} Details</h2>
//             <table className="responsive-table">
//                 <thead>
//                 <tr>
//                     {data.length > 0 &&
//                         Object.keys(data[0]).map((key) => (
//                             <th key={key}>{key.toUpperCase()}</th>
//                         ))}
//                 </tr>
//                 </thead>
//                 <tbody>
//                 {data.map((item, index) => (
//                     <tr key={index}>
//                         {Object.values(item).map((value, i) => (
//                             <td key={i}>{value}</td>
//                         ))}
//                     </tr>
//                 ))}
//                 </tbody>
//             </table>
//         </div>
//     );
// };
//
// export default NichromeAlloys;
