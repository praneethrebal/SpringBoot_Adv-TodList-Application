

#from flask import Flask, render_template, request, redirect, url_for
from flask import Flask, render_template
import sqlite3
import os


app = Flask(__name__, template_folder='templates')

#app = Flask(__name__)
app.config['SECRET_KEY'] = 'your_secret_key'

DATABASE = os.path.join(app.root_path, 'tasks.db')

def create_table():
    with sqlite3.connect(DATABASE) as connection:
        cursor = connection.cursor()
        cursor.execute('CREATE TABLE IF NOT EXISTS tasks (id INTEGER PRIMARY KEY AUTOINCREMENT, task TEXT);')

@app.route('/')
def index():
    create_table()
    tasks = []
    with sqlite3.connect(DATABASE) as connection:
        cursor = connection.cursor()
        cursor.execute('SELECT * FROM tasks;')
        tasks = cursor.fetchall()
    return render_template('index.html', tasks=tasks)

@app.route('/add', methods=['POST'])
def add():
    task = request.form['task']
    with sqlite3.connect(DATABASE) as connection:
        cursor = connection.cursor()
        cursor.execute('INSERT INTO tasks (task) VALUES (?);', (task,))
    return redirect(url_for('index'))

@app.route('/delete/<int:task_id>')
def delete(task_id):
    with sqlite3.connect(DATABASE) as connection:
        cursor = connection.cursor()
        cursor.execute('DELETE FROM tasks WHERE id = ?;', (task_id,))
    return redirect(url_for('index'))

if __name__ == '__main__':
    app.run(debug=True)
