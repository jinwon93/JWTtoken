import React , { useState , useEffect , useCallback} from "react";
import * as authAction from  './AuthAction';



// action 함수로 불러와 전역상태 로직

let logoutTimer : NodeJS.Timeout;


type  Props  = {chidren?:React.ReactNode}
type UserInfo = { userId : string};
type LoginToken ={

    grantType : string,
    accessToken : string,
    tokenExpiresIn : number
}

const AuthContext = React.createContext({

    token : '' ,
    userObj : {userId: ''},
    isLoggedIn : false ,
    isSuccess : false,
    isGetSuccess :false ,
    signup : (userId : string , password : string) => {},
    login :  (userId :string , password :string) => {},
    logout : () => {},
    getUser : () => {}
});



export  const AuthContextProvider:React.FC<Props> = (props) => {

    const tokenData = authAction.retrieveStoredToken();

    let initialToken : any;
    if (tokenData) {
        initialToken = tokenData.token;
    }

    const [token  ,setToken] = useState(initialToken);
    const [userObj  ,setUserObj] = useState({
        userId : ''
    });

    const [isSuccess , setIsSuccess] = useState<boolean>(false);
    const [isGetSuccess , setIsGetSuccess ] = useState<boolean>(false);


    const userIsLoggedIn = !!token;

    const signupHandler = (userId : string , password : string) => {
        setIsSuccess(false);
        const response = authAction.signupActionHandler(userId ,  password);

        response.then((result) => {
            if (result !== null) {
                setIsSuccess(true);
            }
        });
    }

    const loginHandler =  (userId : string , password: string) => {

        setIsSuccess(false);
        const data = authAction.loginActionHandler(userId , password);
        data.then((result) =>{
            if (result !== null) {
                const loginData:LoginToken = result.data;
                setToken(loginData.accessToken);
                logoutTimer = setTimeout(
                    logoutHandler,
                    authAction.loginTokenHandler(loginData.accessToken , loginData.tokenExpiresIn)
                );

                setIsSuccess(true);

            }
        })
    };

    const logoutHandler = useCallback(() => {
        setToken('');
        authAction.logoutActionHandler();
        if (logoutTimer)  {
            clearTimeout(logoutTimer);
        }
    } , []);

    const getUserHandler = () => {
        setIsGetSuccess(false);
        const data = authAction.getUserActionHandler(token);
        data.then((result) => {
            if (result !== null) {
                const userData:UserInfo = result.data;
                setUserObj(userData);
                setIsGetSuccess(true);
            }
        })
    }


    useEffect(() => {

        if (tokenData) {
            logoutTimer = setTimeout(logoutHandler , tokenData.duration);
        }
    } , [tokenData, logoutHandler]);

    const contextValue = {

        token,
        userObj ,
        isLoggedIn: userIsLoggedIn,
        isSuccess ,
        isGetSuccess ,
        signup : signupHandler,
        login : loginHandler,
        logout : logoutHandler,
        getUser : getUserHandler

    }

    return (

        <AuthContext.Provider value={contextValue} >
            {props.chidren}
        </AuthContext.Provider>
    )
 }

export default  AuthContext;