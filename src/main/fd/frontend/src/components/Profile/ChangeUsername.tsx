import React , { useContext , useRef} from "react";
import  {useNavigate} from "react-router-dom";
import AuthContext from "../../store/AuthContext";



const ChangeUsername = () => {

    let navigate = useNavigate();

    const authCtx  = useContext(AuthContext);
    const nicknameInputRef = useRef<HTMLInputElement>(null);

    const submitHandler = (event :  React.FormEvent) => {

        event.preventDefault();
        const enteredNickname = nicknameInputRef.current!.value;

        authCtx.changeNickname(enteredNickname);
        if (authCtx.isSuccess) {
            authCtx.getUser();
            alert("변경 되었습니다.!!");
            navigate("/" ,  {replace : true});
        }
    }

    return (

        <div>new!!! </div>
    )
}




export  { ChangeUsername } ;