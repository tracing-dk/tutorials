import React from 'react';
import './App.css';

import { Tracer, ExplicitContext, BatchRecorder, jsonEncoder } from 'zipkin';
import wrapFetch from 'zipkin-instrumentation-fetch';
import { HttpLogger } from 'zipkin-transport-http';

const { JSON_V2 } = jsonEncoder;

const zipkinBaseUrl = 'http://localhost:9411';
const tracer = new Tracer({
  ctxImpl: new ExplicitContext(),
  recorder: new BatchRecorder({
    logger: new HttpLogger({
      endpoint: `${zipkinBaseUrl}/api/v2/spans`,
      jsonEncoder: JSON_V2,
      fetch,
    }),
  }),
  localServiceName: 'cinema-frontend',
});

export default class App extends React.Component {
  state = {
    repertoire: 'Not loaded',
    tracer,
    fetch: wrapFetch(fetch, { tracer, remoteServiceName: 'repertoire' }),
  };

  componentWillMount() {
    this.state.tracer.local('repertoire', () =>
      this.state.fetch("http://localhost:8080/repertoire")
        .then(response => response.text())
        .then(repertoire =>
          this.setState({
            repertoire: repertoire,
          })
        ).catch(e => console.error(e))
    );
  }

  render() {
    return (
      <div>
        {this.state.repertoire}
      </div>
    );
  }
}
