import React, { Component } from 'react'
import { Collapse, CardBody, Card } from 'reactstrap';
import {Link} from 'react-router-dom'
import './style.css';

export default class MobileMenu2 extends Component {

    state = {
        isMenuShow: false,
        isOpen: false,
    }

    menuHandler = () => {
        this.setState({
            isMenuShow: !this.state.isMenuShow
        })
    }

    setIsOpen = () => {
        this.setState({
            isOpen: !this.state.isOpen
        })
    }

    render() {

        const { isMenuShow, isOpen } = this.state;

        return (
            <div>
                <div className={`mobileMenu ${isMenuShow ? 'show' : ''}`}>
                    {/* <div className="clox" onClick={this.menuHandler}>Close Me</div> */}
                    <div className="logo2">
                        <h2><AnchorLink to='#home' onClick={this.menuHandler}>Simone & Thiago</AnchorLink></h2>
                    </div>
                    <ul className="responsivemenu">
                        <li><Link to='/home' onClick={this.menuHandler}>Casal</Link></li>
                        <li><Link to='/home' onClick={this.menuHandler}>Madrinhas e Padrinhos</Link></li>
                        <li><Link to='/home' onClick={this.menuHandler}>Cerimônia</Link></li>
                        <li><Link to='/home' onClick={this.menuHandler}>Confirmação</Link></li>
                        <li><Link to='/home' onClick={this.menuHandler}>Presentes</Link></li>
                    </ul>
                    
                </div>

                <div className="showmenu" onClick={this.menuHandler}><i className="fa fa-bars" aria-hidden="true"></i></div>         
            </div>
        )
    }
}
