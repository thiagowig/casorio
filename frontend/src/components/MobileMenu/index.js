import React, { Component } from 'react'
import AnchorLink from 'react-anchor-link-smooth-scroll'
import { Collapse, CardBody, Card } from 'reactstrap';
import {Link} from 'react-router-dom'
import './style.css';

export default class MobileMenu extends Component {

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
                    <div className="logo2">
                        <h2><AnchorLink href='#home' onClick={this.menuHandler}>Simone & Thiago</AnchorLink></h2>
                    </div>
                    <ul className="responsivemenu">
                        <li><AnchorLink href='#couple' onClick={this.menuHandler}>Casal</AnchorLink></li>
                        <li><AnchorLink href='#people' onClick={this.menuHandler}>Madrinhas e Padrinhos</AnchorLink></li>
                        <li><AnchorLink href='#event' onClick={this.menuHandler}>Cerimônia</AnchorLink></li>
                        <li><AnchorLink href='#rsvp' onClick={this.menuHandler}>Confirmação</AnchorLink></li>
                        <li><AnchorLink href='#gift' onClick={this.menuHandler}>Presentes</AnchorLink></li>
                    </ul>
                    
                </div>

                <div className="showmenu" onClick={this.menuHandler}><i className="fa fa-bars" aria-hidden="true"></i></div>         
            </div>
        )
    }
}
