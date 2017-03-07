import { Link } from 'react-router'
import React from 'react';

export default class NavbarOption extends React.Component {

  render() {
    let route = this.props.route;
    
    return <li><Link to={"/" + route.path}>{ route["navbar-name"] }</Link></li>;
  }
}
