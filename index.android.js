'use strict';

import React from 'react';
import {
  AppRegistry,
  StyleSheet,
  Text,
  View,
  ScrollView,
} from 'react-native';

class HelloWorld extends React.Component {
  render() {
    return (
      <View style={styles.container}>
      <ScrollView style={{flex: 1}}>
        <Text style={styles.hello}>Hello, World</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>
        <Text style={styles.hello}>Helld</Text>

		</ScrollView>
      </View>
    )
  }
}
var styles = StyleSheet.create({
  container: {
    flex: 1,
    justifyContent: 'center',
    backgroundColor: '#f88',
  },
  hello: {
    fontSize: 20,
    textAlign: 'center',
    margin: 10,
  },

  hello2: {
    fontSize: 14,
    textAlign: 'center',
    margin: 10,
    color: '#00f',
  },
});

AppRegistry.registerComponent('Hello', () => HelloWorld);