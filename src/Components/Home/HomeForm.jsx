import {Link} from "react-router-dom";

const HomeForm = () => {
    return(
        <section>
            <h1>Home</h1>
            <p>
                <span className={"line"}>
                    <Link to={"/MaterialSideBar"}>Materials </Link>
                </span>
            </p>
            <p>
                About Us<br/>
                <span className={"line"}>
                    <Link to={"/RegisterForm"}>Register</Link>
                </span>
            </p>

        </section>
    )
}

export default HomeForm;