import React, { Component } from 'react';

class LoginPage extends Component {

  doLogin = () => {
    const userNameRef = this.refs.username;
    const passwordRef = this.refs.password;

    this.props.handleLogin(userNameRef.value, passwordRef.value);
  }

  render() {
    return (
      <div>
        <h1 className="page-title">Login Page</h1>
        <div className="row">
          <div className="columns small-centered small-10 medium-6 large-4">
            <div className="callout callout-auth">

                <label className="input-form"> Username:
                    <input type="text" name="username" ref="username" placeholder="input username..."/>
                </label>

                <label className="input-form"> Password:
                      <input type="password" name="password" ref="password" placeholder="input password..."/>
                </label>

                <button className="success button expanded" onClick={this.doLogin}>Log In</button>

                <p className="error-message">{this.props.loginErrorMSG}</p>
            </div>
          </div>
        </div>

      </div>
    );
  }
}

export default LoginPage;
