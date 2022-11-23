import React, { useContext } from 'react';
import {Routes , Route , Navigate} from "react-router-dom";
import AuthContext from "./store/AuthContext";

import CreateAccountForm from "./components/CreateAccountForm";
import Layout from "./components/layout/Layout";
import AuthPage from "./pages/AuthPage";
import HomePage from "./pages/HomePage";
import CreateAccountPage from "./pages/CreateAccountPage";


function App() {

    const authCtx = useContext(AuthContext);



    return (
        <Layout>
            <Routes>
                <Route path="/" element={<HomePage />} />
                <Route path="/signup" element={authCtx.isLoggedIn ? <Navigate to='/'/> : <CreateAccountPage />} />
                <Route path="/login/*"
                       element={authCtx.isLoggedIn ? <Navigate to='/' /> : <AuthPage /> } />

            </Routes>
        </Layout>
    );
}

export default App;
