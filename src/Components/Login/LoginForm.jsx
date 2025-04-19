import './LoginForm.css'
import { FaUser, FaLock } from "react-icons/fa";
import {Link} from "react-router-dom";
import {useEffect, useRef, useState} from "react";
import { useNavigate } from "react-router-dom";


const LoginForm = () => {
    const navigate = useNavigate();

    const userRef = useRef();
    const errRef = useRef();

    const [user, setUser] = useState('');
    const [pwd, setPwd] = useState('');
    const [errMsg, setErrMsg] = useState('');
    const [success, setSuccess] = useState(false);

    useEffect(() => {
        userRef.current.focus();
    }, []);

    useEffect(() => {
        setErrMsg('');
    }, [user, pwd]);

    const handleSubmit = async (e) => {
        e.preventDefault();
        console.log(user, pwd);
        setUser('');
        setPwd('');
        let isAuthenticated = false;
        fetch(`http://localhost:8000/user/checkUserAndPwd`, {
            method: 'post',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify({"username": user, "password": pwd})
        })
            .then(response => response.json())
            .then(data => {
                isAuthenticated = data;
                console.log(data);
                if (isAuthenticated === true) {
                    setSuccess(true);
                }
                else {
                    alert("Username or password invalid");
                }
            })
            .catch(error => console.error(error));
    }

    return (
        <>
            {success ? (
                navigate("/HomeForm")
            ) : (

                <section>
                    <p ref={errRef} className={errMsg ? "errmsg" : "offscreen"} aria-live={"assertive"}>{errMsg}</p>
                    <h1>Login</h1>
                    <form onSubmit={handleSubmit}>
                        <label htmlFor={"username"}>Username:</label>
                        <input
                            type={"text"}
                            id={"username"}
                            ref={userRef}
                            autoComplete={"off"}
                            onChange={(e) => setUser(e.target.value)}
                            value={user}
                            required
                        />

                        <label htmlFor={"password"}>Password:</label>
                        <input
                            type={"password"}
                            id={"password"}
                            onChange={(e) => setPwd(e.target.value)}
                            value={pwd}
                            required
                        />

                        <button>Login</button>

                    </form>
                    <p>
                        Don't have an account?<br/>
                        <span className={"line"}>
                            <Link to={"/RegisterForm"}>Register</Link>
                        </span>
                    </p>
                </section>
            )}
        </>
    );
};

export default LoginForm;