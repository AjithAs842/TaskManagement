import React, { Component } from 'react';
import './App.css';
import axios from 'axios';

import Fab from '@material-ui/core/Fab';
import AddIcon from '@material-ui/icons/Add';

class List extends Component {

    state = {

        text: '',
        showText: false,
        task: [],
        status: '',
    }


    componentDidMount() {
        this.fetchTask();
    }


    add() {
        
         this.setState({
              showText: !this.state.showText,
              text:""
                 }) 
        
        if (this.state.text !== "") {
            axios.post("http://localhost:8081/taskcontroller/add", {
                task: this.state.text,

            }).then((result) => {
                this.componentDidMount();


                if (result.status === 200) {
                    alert('Saved Successfully')
                }
                else {
                    alert('Save failed!!!')
                }
            })
        }

        else {
            alert("No Data")
        }

    }

    fetchTask = () => {
        axios.get("http://localhost:8081/taskcontroller/find")
            .then((results) => {

                console.log(results.data, "result")
                this.setState({
                    task: results.data,
                })
            })


    }


    CheckboxChange = (item) => {
        axios.post("http://localhost:8081/taskcontroller/findTask",{
            id: item.id
        })
            .then((res) => {
                this.fetchTask();

            })

    }



    render() {
        return (
            <div>
                <div>

                    <div >
                        <header>
                            <div >
                                <Fab className="add" color="secondary" aria-label="add"
                                    onClick={() => this.setState({ showText: !this.state.showText })}>
                                    <AddIcon />

                                </Fab>
                                <h3 className="buttondtext">Add a task </h3>
                            </div>
                            {
                                this.state.showText ?
                                    <div>

                                        <div className="to-do-form" >
                                            <input type="text" placeholder="Enter task"
                                                onChange={(e) => { this.setState({ text: e.target.value, }) }}></input>
                                            <button onClick={(e) => this.add()}
                                                 >Add</button>
                                        </div>

                                    </div>
                                    : null
                            }



                        </header>
                    </div>

                </div>

                <div>
                    {
                        this.state.task.map((item) => {
                            return (
                                <div>
                                    <div>
                                        <input type="checkbox"
                                            style={{ margin: '20px', boxSizing: "10px" }}
                        
                                            checked={item.status === true ? true : false}
                                            onChange={() => { this.CheckboxChange(item) }}
                                        />
                                            {console.log(item.status)}
                                        <span style={(item.status === true) ? { textDecoration: 'line-through' } :
                                         { textDecoration: 'none' }} className="listText">
                                                   {item.task} 
                                         </span>
                                        <hr style={{ marginLeft: "10%" }} />

                                    </div>


                                </div>
                            )
                        })


                    }
                </div >
            </div>

        )
    }
}



export default List;
