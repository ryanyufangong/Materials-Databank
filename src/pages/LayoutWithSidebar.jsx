import { Outlet } from "react-router-dom";
import MaterialSideBar from "../Components/Materials/MaterialSideBar";

function LayoutWithSidebar() {
    return (
        <>
            <MaterialSideBar />
            <div style={{ marginLeft: "250px", padding: "20px" }}>
                <Outlet />
            </div>
        </>
    );
}

export default LayoutWithSidebar;
