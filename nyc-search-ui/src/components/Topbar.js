import React, { Component } from 'react';

class Topbar extends Component {

  renderBasedOnLogin = () => {
    if(this.props.login) {
      return (
        <div className="top-bar">
            <div className="top-bar-left">
              <ul className="menu">
                  <li className="menu-text" onClick={()=>{this.props.renderContent("HomePage")}}>Welcome {this.props.userName}!</li>
              </ul>
            </div>
            <div className="top-bar-right">
              <ul className="menu">
                <li><button className="hollow button success" onClick={()=>{this.props.renderContent("ConfigurePage")}}>Settings</button></li>
                <li><button className="hollow button alert" onClick={()=>{this.props.handleDelete()}}>Delete</button></li>
                <li><button className="hollow button secondary" onClick={()=>{this.props.handleLogout()}}>Logout</button></li>
              </ul>
            </div>
        </div>
      );
    } else {
      return (
        <div className="top-bar">
            <div className="top-bar-left">
              <ul className="menu">
                  <li className="menu-text" onClick={()=>{this.props.renderContent("HomePage")}}>Welcome to NYC Search!</li>
              </ul>
            </div>
            <div className="top-bar-right">
              <ul className="menu">
                <li><button className="hollow button success" onClick={()=>{this.props.renderContent("LoginPage")}}>Login</button></li>
                <li><button className="hollow button warning" onClick={()=>{this.props.renderContent("SignupPage")}}>Signup</button></li>
              </ul>
            </div>
        </div>
      );
    }
  }

  render() {
    return (
      <div>
        {this.renderBasedOnLogin()}
      </div>
    );
  }
}

export default Topbar;
