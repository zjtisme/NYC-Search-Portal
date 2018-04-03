import React from 'react';
import { mount, shallow, render } from 'enzyme';

import ConfigurePage from '../components/ConfigurePage';

describe('ConfigurePage', () => {
  it('should render configure page', () => {
    const wrapper = shallow(<ConfigurePage/>);

    expect(wrapper.find('#configure-page')).toExist();
  });

  it('should render firstname input', () => {
    const wrapper = shallow(<ConfigurePage/>);

    expect(wrapper.find('#configure-firstname')).toExist();
  });

  it('should respond to change event and change the state', () => {
    const wrapper = mount(<ConfigurePage firstName={"Tony"}/>);

    wrapper.find('#configure-firstname').simulate('change', {target: {
      name: 'firstName', value: 'updated firstname'
    }});

    expect(wrapper.instance().state.updatedUser.firstName).toEqual('updated firstname');
  });
});
