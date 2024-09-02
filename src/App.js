import LoginForm from "./Components/Login/LoginForm";
import RegisterForm from "./Components/Register/RegisterForm";
import HomeForm from "./Components/Home/HomeForm";
import MaterialSideBar from "./Components/Material/MaterialSideBar";
import {BrowserRouter as Router, Routes, Route, Navigate} from "react-router-dom";
import axios from "axios";

function App() {
    return (
        <>
            <Router>
                <Routes>
                    <Route exact path={"/RegisterForm"} element={<RegisterForm/>} />
                    <Route exact path={"/LoginForm"} element={<LoginForm/>} />
                    <Route exact path={"/HomeForm"} element={<HomeForm/>} />
                    <Route exact path={"/MaterialSideBar"} element={<MaterialSideBar/>} />
                </Routes>
            </Router>
        </>
    );
}

export default App;