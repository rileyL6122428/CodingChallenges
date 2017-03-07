// import { Link } from 'react-router'
import NavbarOption from './NavbarOption.jsx';
import React from 'react';

export default class Navbar extends React.Component {

  render() {
    return (
      <section id="nav">
        <nav>
          <div id="site-header">
            <img src="images/code_em_all.svg" id="site-logo"/>
            <h1>Solve em All</h1>
          </div>

          <ul id="nav-options">
            {this.props.routes.map((route, idx) => {
              return <NavbarOption key={idx} route={route} />;
            })}
          </ul>
        </nav>
      </section>
    );
  }
}
