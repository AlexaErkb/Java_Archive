import React, {useState} from 'react';
import { Text, View, StyleSheet, TextInput, TouchableOpacity, Alert, Button, Image } from 'react-native';
import { useNavigation } from '@react-navigation/native';

const Result = ({ route, navigation }) => {
  const [pass, onChangePass] = useState(true);
  var msg = ''
  var msg2 = ''
  const { password } = route.params;
  const { email } = route.params;
  const { type } = route.params;

  if (type == 1) {
    msg = 'Авторизация прошла успешно'
    msg2 = 'Приветствуем, '
  } else {
    msg = 'Регистрация прошла успешно'
    msg2 = 'Добро пожаловать, '
  }
  return (
    <View style={styles.container}>
      <View style={styles.form}>
        <Text style={styles.title}>{msg}</Text>
        <Text style={styles.info}>{msg2}{email}</Text>
        <View style={{flexDirection: 'row'}}>
        <Text style={styles.info}>Ваш пароль: {pass ? '*'.repeat(password.length) : password}</Text>
        <Button title='Показать пароль' onPress={() => onChangePass(!pass)} color='black'/>
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: '#3b4247',
    padding: 8,
  },
  form: {
    alignContent: 'center',
    borderRadius: '30px',
    justifyContent: 'center',
    alignSelf: 'center',
    textAlign: 'center',
    width: '90%',
    height: '85%',
    backgroundColor: '#fff',
  },
  title: {
    textAlign:'center',
    marginBottom: '6%',
    fontWeight: 'bold',
    color: '#3b4247',
    fontSize: 25,
    fontFamily: 'Verdana'
  },
  info: {
    alignSelf: 'center',
    textAlign:'center',
    marginStart: '2%',
    color: 'gray',
    fontSize: 20,
    fontFamily: 'Verdana'
  },
  quest: {
    marginTop:'15%',
    textAlign:'center',
    marginHorizontal: '15%',
    color: '#3b4247',
    fontSize: 14.5,
    fontFamily: 'Verdana'
  },
  input: {
    flex:1,
    fontSize: 15,
    height: 40,
    marginTop: '3%',
    padding: '3%',
  },
  button: {
    paddingHorizontal: '3%',
    marginHorizontal: '15%',
    marginTop: '10%',
    backgroundColor: '#3b4247',
    alignItems: 'center', 
    justifyContent: 'center',
    borderRadius: 30
  },
  field: {
    flexDirection: 'row',
    alignItems: 'center',
    borderWidth: 1.5,
    marginHorizontal: '15%',
    marginBottom: 10,
    paddingHorizontal: '3%',
    borderColor: 'black',
    borderRadius: '30px',
  },
});

export default Result;
