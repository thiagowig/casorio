import React from 'react';
import {Link} from 'react-router-dom'
import 'react-sticky-header/styles.css';
import MobileMenu2 from '../../components/MobileMenu2'

const Header2 = () => {

    return(
          <div className="Header_root">
            <div  className="header">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-3">
                            <div className="logo">
                                <h2><Link to='/home'>Simone & Thiago</Link></h2>
                            </div>
                        </div>
                        <div className="col-lg-9">
                            <div className="header-menu d-lg-block d-none">
                                <ul className=" mobail-menu d-flex">
                                    <li><Link to='/home'>Home</Link></li>
                                    <li><Link to='/home'>Casal</Link></li>
                                    <li><Link to='/home'>História</Link></li>
                                    <li><Link to='/home'>Pessoas</Link></li>
                                    <li><Link to='/home'>Evento</Link></li>
                                    <li><Link to='/home'>Galeria</Link></li>
                                    <li><Link to='/home'>Confirmação</Link></li>
                                </ul>
                            </div>
                        </div>
                        <div className="col-12">
                            <MobileMenu2/>
                        </div>
                    </div>
                </div>
             </div>
          </div>
    )
}

export default Header2;
