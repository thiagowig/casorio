import React from  'react';

// components
import Couple from '../../components/couple';
import HeroMain from '../../components/HeroMain';
import Welcome from '../../components/welcome-area';
import People from '../../components/people';
import Location from '../../components/location';
import Gallery from '../../components/gallery';
import Rsvp from '../../components/rsvp';
import Getting from '../../components/getting';
import Navbar from '../../components/Navbar'
import Saveday from '../../components/countdown'
import Footer from '../../components/footer'
import couple1 from '../../images/couple/simone.jpg'
import couple2 from '../../images/couple/thiago.jpeg'


const HomeMain = () => {
    return(
       <div>
           <Navbar/>
           <HeroMain/>
           <Saveday saveday={'s2'}/>
           <Couple couple={'s2'} coupleimg1={couple1} coupleimg2={couple2}/>
           <Gallery/>
           <Welcome welcome={'s2'}/>
           <People guest={'guest-style'}/>
           <Location/>
           <Rsvp/>
           <Getting/>
           <Footer footer={'s2'}/>
       </div>
    )
}

export default HomeMain;