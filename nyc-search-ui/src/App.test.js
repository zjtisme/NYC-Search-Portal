import React from 'react';
import { mount, shallow } from 'enzyme';
import App from './App';
import Topbar from './components/Topbar';
import Container from './components/Container';


it('renders without crashing', () => {
  mount(<App />);
});

it('renders Topbar and Container components', () => {
  const wrapper = mount(<App />);
  expect(wrapper).toContainReact(<Topbar login={false} userName={""} renderContent={jest.fn}
    handleLogout={jest.fn} handleDelete={jest.fn}/>);
});
