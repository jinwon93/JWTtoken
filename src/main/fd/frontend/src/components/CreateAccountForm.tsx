import React  ,{ useState  , useRef , useContext} from "react";
import { useNavigate } from "react-router-dom";
import AuthContext from "../store/AuthContext";
import classes from "*.module.css";

const CreateAccountForm = () => {

    let navigate = useNavigate();

    const authCtx  = useContext(AuthContext);
    const userIdInputRef = useRef<HTMLInputElement>(null);
    const passwordInputRef = useRef<HTMLInputElement>(null);


    const submitHandler = (event : React.FormEvent) => {

        event.preventDefault();

        const enteredUserId = userIdInputRef.current!.value;
        const enteredPassword = passwordInputRef.current!.value;


        authCtx.signup(enteredUserId , enteredPassword);

        if (authCtx.isSuccess) {
            return navigate("/" , {replace : true});
        }
    }

    return (
        <section className={classes.auth}>
            <h1>Create Account</h1>
            <form onSubmit={submitHandler}>
                <div className={classes.control}>
                    <label htmlFor="userId">Your ID</label>
                    <input type="text" id="userId" required ref={userIdInputRef} />
                </div>
                <div className={classes.control}>
                    <label htmlFor="password">Your password</label>
                    <input type="password" id="password" required ref={userIdInputRef} />
                </div>
                <div className={classes.aactions}>
                    <button type="submit">Submit</button>
                </div>
            </form>
        </section>
    )
}


export default CreateAccountForm;


