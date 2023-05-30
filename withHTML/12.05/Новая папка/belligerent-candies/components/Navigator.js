import React from 'react';
import { Text, View } from 'react-native';
import { NavigationContainer } from '@react-navigation/native';
import { createStackNavigator } from '@react-navigation/stack';
import Login from './Login'
import Register from './Register'
import Result from './Result'

const AppStack = createStackNavigator();

const Navigate = (props) => {

  return (
    <AppStack.Navigator>
      <AppStack.Screen name="Регистрация" component={Register}/>
      <AppStack.Screen name="Авторизация" component={Login}/>
      <AppStack.Screen name="Сообщение" component={Result}/>
    </AppStack.Navigator>
  );
};

export default Navigate;