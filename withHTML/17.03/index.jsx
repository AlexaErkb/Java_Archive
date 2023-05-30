
class TodoApp extends React.Component {  constructor(props) {
    super(props);
    this.state = { items: [], text: '' };
    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  render() {
    return (
      <div align='center'>
        <h3 style={{background: '#fff8dc'}}><font face='consolas' size='30'>Список дел</font></h3>
        <TodoList items={this.state.items}/>
        <form onSubmit={this.handleSubmit}>
        <font face='Verdana'>
          <label htmlFor="new-todo">
            Какие дела на сегодня?
          </label>
          <input style={{margin:'10px'}}
            id="new-todo"
            onChange={this.handleChange}
            value={this.state.text}
          />
          <button style={{background: '#f2e8c9', borderWidth:'1px'}}>
            Добавить #{this.state.items.length + 1}
          </button>
         </font> 
        </form>
      </div>
    );
  }

  handleChange(e) {
    this.setState({ text: e.target.value });
  }

  handleSubmit(e) {
    e.preventDefault();
    if (this.state.text.length === 0) {
      return;
    }
    const newItem = {
      text: this.state.text,
      id: Date.now()
    };
    this.setState(state => ({
      items: state.items.concat(newItem),
      text: ''
    }));
  }
}

class TodoList extends React.Component {
  render() {
    return (
      <ul style={{display: 'table'}}>
        {this.props.items.map(item => (
          <li key={item.id} style={{textAlign:'center'}}><font face='Verdana'>{item.text}</font></li>
        ))}
      </ul>
    );
  }
}

ReactDOM.render(
  <TodoApp />,
  document.getElementById('app')
);
