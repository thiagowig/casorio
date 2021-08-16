import React from 'react';
import './style.css'

const Footer = (props) => {
    return(
        <div className={`site-footer ${props.footer}`}>
            <div className="container">
                <div className="row">
                    <div className="text">
                        <h2>Simone & Thiago</h2>
                        <p>Obrigado</p>
                    </div>
                </div>
            </div> 
        </div>
    )
}

export default Footer;