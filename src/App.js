import LoginForm from "./Components/Login/LoginForm";
import RegisterForm from "./Components/Register/RegisterForm";
import HomeForm from "./Components/Home/HomeForm";
import MaterialSideBar from "./Components/Materials/MaterialSideBar";
import {BrowserRouter as Router, Routes, Route, Navigate} from "react-router-dom";

import LayoutWithSidebar from "./pages/LayoutWithSidebar";
import NichromeAlloys from "./pages/NichromeAlloys";
import MaterialsPage from "./pages/MaterialsPage";

function App() {
    return (
        <>
            <Router>
                <Routes>
                    <Route exact path={"/RegisterForm"} element={<RegisterForm/>} />
                    <Route exact path={"/LoginForm"} element={<LoginForm/>} />
                    <Route exact path={"/HomeForm"} element={<HomeForm/>} />

                    <Route exact path={"/MaterialSideBar"} element={<MaterialSideBar/>} />

                    <Route element={<LayoutWithSidebar />}>
                        <Route path="/Nichrome_alloys" element={<NichromeAlloys/>} />
                        <Route path="/materials" element={<MaterialsPage />} />
                    </Route>

                </Routes>
            </Router>
        </>
    );
}

export default App;