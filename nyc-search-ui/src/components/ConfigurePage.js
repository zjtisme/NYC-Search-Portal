import React, { Component } from 'react';

class ConfigurePage extends Component {

  state = {
    updatedUser: {
      'userName': this.props.userName,
      'pass1': this.props.password,
      'pass2': this.props.password,
      'firstName': this.props.firstName,
      'lastName': this.props.lastName,
      'gender': this.props.gender,
      'email': this.props.email,
      'phoneNumber': this.props.phoneNumber,
      'birthday': this.props.birthday
    }
  }

  handleChange = (e) => {
    const fieldName = e.target.name;
    const fieldValue = e.target.value;

    const curUser = this.state.updatedUser;
    curUser[fieldName] = fieldValue;

    this.setState({updatedUser: curUser});
  }

  doModify = () => {
    const username = this.state.updatedUser.userName;
    const pass1 = this.state.updatedUser.pass1;
    const pass2 = this.state.updatedUser.pass2;
    const firstname = this.state.updatedUser.firstName;
    const lastname = this.state.updatedUser.lastName;
    const gender = this.state.updatedUser.gender;
    const email = this.state.updatedUser.email;
    const phonenumber = this.state.updatedUser.phoneNumber;
    const birthday = this.state.updatedUser.birthday;

    this.props.handleUpdate(username, pass1, pass2, firstname, lastname, gender, email, phonenumber, birthday);
  }

  render() {
    return (
      <div>
        <h1 className="page-title">Your Profile</h1>
          <div className="row">
            <div className="columns small-centered small-10 medium-6 large-4">
              <div className="callout callout-auth">
          <label className="input-form">Username:
            <input type="text" ref="username" name="userName" value={this.state.updatedUser.userName} onChange={this.handleChange}/>
          </label>
          <label className="input-form">Password:
            <input type="password" ref="pass1" name="pass1" value={this.state.updatedUser.pass1} onChange={this.handleChange}/>
          </label>
          <label className="input-form">Password Again:
            <input type="password" ref="pass2" name="pass2" value={this.state.updatedUser.pass2} onChange={this.handleChange}/>
          </label>
          <label className="input-form">FirstName:
            <input type="text" ref="firstname" name="firstName" value={this.state.updatedUser.firstName} onChange={this.handleChange}/>
          </label>
          <label className="input-form">LastName:
            <input type="text" ref="lastname" name="lastName" value={this.state.updatedUser.lastName} onChange={this.handleChange}/>
          </label>
          <label className="input-form">Gender:
            <input type="text" ref="gender" name="gender" value={this.state.updatedUser.gender} onChange={this.handleChange}/>
          </label>
          <label className="input-form">Email:
            <input type="text" ref="email" name="email" value={this.state.updatedUser.email} onChange={this.handleChange}/>
          </label>
          <label className="input-form">PhoneNumber:
            <input type="text" ref="phonenumber" name="phoneNumber" value={this.state.updatedUser.phoneNumber} onChange={this.handleChange}/>
          </label>
          <label className="input-form">Birthday:
            <input type="text" ref="birthday" name="birthday" value={this.state.updatedUser.birthday} onChange={this.handleChange}/>
          </label>
          <button className="success button expanded" onClick={this.doModify}>Submit</button>
          <p className="error-message">{this.props.configureErrorMSG}</p>
        </div>
      </div>
    </div>
  </div>
    );
  }
}

export default ConfigurePage;
