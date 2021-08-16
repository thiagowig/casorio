import React from 'react';
import { BrowserRouter as Router, Switch, Route } from 'react-router-dom'
import HomeMain from '../HomeMain/index'
import Homepage from '../HomePage/index'
import Homepage4 from '../HomePage4/index'
import Scrollbar from '../../components/scrollbar'

      

const AllRoute = () => { 

  return (
    <div className="App">
       <Router>
            <Switch>
              <Route exact path='/' component={Homepage4} />
              <Route path='/home' component={HomeMain} />
              <Route path='/home2' component={Homepage} />
            </Switch>
            <Scrollbar />
          </Router>
      
    </div>
  );
}

export default AllRoute;
