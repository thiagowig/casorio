import React from 'react';
import {Link} from 'react-router-dom'
import AnchorLink from 'react-anchor-link-smooth-scroll'
import 'react-sticky-header/styles.css';
import MobileMenu from '../../components/MobileMenu'



import './style.css'

const Header = () => {

    return(

          <div className="Header_root">
            <div className="header">
                <div className="container">
                    <div className="row">
                        <div className="col-lg-3">
                            <div className="logo">
                                <h2><Link to='/home'>Simone & Thiago</Link></h2>
                            </div>
                        </div>
                        <div className="col-lg-9">
                            <div className="header-menu d-lg-block d-none">
                                <ul className="mobail-menu d-flex">
                                    <li><AnchorLink href='#couple'>Casal</AnchorLink></li>
                                    <li><AnchorLink href='#people'>Madrinhas e Padrinhos</AnchorLink></li>
                                    <li><AnchorLink href='#event'>Cerimônia</AnchorLink></li>
                                    <li><AnchorLink href='#rsvp'>Confirmação</AnchorLink></li>
                                    <li><AnchorLink href='#gift'>Presentes</AnchorLink></li>
                                </ul>
                            </div>
                        </div>
                        <div className="col-12">
                            <MobileMenu/>
                        </div>
                    </div>
                </div>
             </div>
          </div>
        
    )
}

export default Header;
