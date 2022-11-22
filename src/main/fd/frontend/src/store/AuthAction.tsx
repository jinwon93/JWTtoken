import  {GET , POST} from "./FetchAuthAction";


const createTokenHeader = (token :string) => {

    return {
        header : {
            'Authorization' : 'Bearer' + token
        }
    }
}

const calculateRemainingTime = (expirationTime:number) => {

    const currentTime = new Date().getTime();
    const adjExpirationTime = new Date(expirationTime).getTime();
    const remainingDuration = adjExpirationTime - currentTime;
    return remainingDuration;
};


export const loginTokenHandler = (token:string , expirationTime : number) => {

    localStorage.setItem('token' , token);
    localStorage.setItem('expirationTime' , String(expirationTime));

    const remainingTime = calculateRemainingTime(expirationTime);
    return remainingTime;
}


export const retrieveStoredToken = () => {
    const storedToken = localStorage.getItem('token');
    const storedExpirationDate = localStorage.getItem("expirationTime") || '0';
    const remaingTime = calculateRemainingTime(+ storedExpirationDate);

    if (remaingTime  <= 1000) {
        localStorage.removeItem('token');
        localStorage.removeItem('expirationTime');
        return null;
    }

    return {
        token:storedToken,
        duration:remaingTime
    }
}

export const signupActionHandler = (userId:string , pw : string) => {

    const URL =  '/user/signUp'
    const signupObject = { userId , pw} ;

    const response = POST(URL , signupObject , {});
    return response;
};

export  const loginActionHandler = (userId :string , pw : string) => {

    const URL = '/user/login'
    const loginObject =  { userId , pw};
    const response = POST(URL , loginObject , {});

    return response;
};


export const logoutActionHandler = () => {

    localStorage.removeItem('token');
    localStorage.removeItem("expirationTime");
};

export const getUserActionHandler =  (token:string) => {

    const URL = "/user/info";
    const response = GET(URL , createTokenHeader(token));
    return response;
};
