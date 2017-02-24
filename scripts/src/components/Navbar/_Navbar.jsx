import React from 'react';

export default class Navbar extends React.Component {

  render() {
    let routes = this.props.routes;

    return (
      <section id="nav">
        <nav>
          <div id="site-header">
            <img src="images/code_em_all.svg" />
            <h1>Solve em All</h1>
          </div>

          <ul id="nav-options">
            {routes.map((route, idx) => {
              return <li key={idx}>{ route["navbar-name"] }</li>;
            })}
          </ul>
        </nav>
      </section>
    );
  }
}
