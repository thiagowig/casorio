import React, { Component } from 'react';
import CountDown from 'reactjs-countdown';
import './style.css'
 
class Saveday extends Component {

    render() {
        return(
            <div className={`saveday ${this.props.saveday}`}>
                <div className="container">
                    <div className="row">
                        <div className="col-12">
                            <div className="countdownwrap">
                                <CountDown
                                    deadline="14 Nov 2021 16:00:00"
                                />
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            
        );
    }
}
 
export default Saveday;