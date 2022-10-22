package com.example.martoo.poultry;
import android.app.AlertDialog;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Batch6 extends  AppCompatActivity {
    DatabaseHelper6 myDb1;
    EditText editBatchNumber, editStartDate,editEndDate,editOrigin,editTotal, editWeight, editRoom ,  editID ;
    Button btnAddData,btnvieReset,btnviewHome ;
    Button btnviewAll;
    Button btnDelete;

    Button btnviewUpdate;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.batch6);
        myDb1 = new DatabaseHelper6(this);

        editBatchNumber = (EditText)findViewById(R.id.batchNumber);
        editStartDate = (EditText)findViewById(R.id.editStartDate);
        editEndDate = (EditText)findViewById(R.id.edtEndDate);
        editOrigin= (EditText)findViewById(R.id.edTbatchOrigin);
        editTotal = (EditText)findViewById(R.id.batchTotal);
        editWeight = (EditText)findViewById(R.id.edTbodyWeight);
        editRoom = (EditText)findViewById(R.id.edTroomNumber);
        editID = (EditText)findViewById(R.id.edTiD);
        btnAddData = (Button)findViewById(R.id.buttonAdd);
        btnviewAll = (Button)findViewById(R.id.button_viewAll);
        btnvieReset = (Button)findViewById(R.id.buttonReset);
        btnviewHome = (Button)findViewById(R.id.buttonHome);
        btnviewUpdate= (Button)findViewById(R.id.buttonUpdatee);
        btnDelete= (Button)findViewById(R.id.buttonDelete);

        AddDataa();
      // viewA();
       UpdateDataa();
        DeleteDataa();
    }
   public void DeleteDataa() {
        btnDelete.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Integer deletedRows = myDb1.deleteDataa(  editID.getText().toString());
                        if(deletedRows > 0)
                            Toast.makeText(Batch6.this,"Data Deleted successfully",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Batch6.this,"Data not Deleted",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public void UpdateDataa() {
        btnviewUpdate.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        boolean isUpdate = myDb1.updateDataa( editID.getText().toString(),
                                editBatchNumber.getText().toString(), editStartDate.getText().toString(), editEndDate.getText().toString(),editOrigin.getText().toString(),editTotal.getText().toString(),  editWeight.getText().toString(),  editRoom.getText().toString());
                        if(isUpdate == true)
                            Toast.makeText(Batch6.this,"Data Update",Toast.LENGTH_LONG).show();
                        else
                            Toast.makeText(Batch6.this,"Data not Updated",Toast.LENGTH_LONG).show();
                    }
                }
        );
    }
    public  void AddDataa() {
        btnAddData.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                            boolean isInserted = myDb1.insertDat(editBatchNumber.getText().toString(),editStartDate.getText().toString(),editEndDate .getText().toString(),
                                    editOrigin.getText().toString(),editTotal .getText().toString(),editWeight .getText().toString(),
                                    editRoom .getText().toString() );
                            if(isInserted == true)
                                Toast.makeText( Batch6.this,"Data Inserted successfully",Toast.LENGTH_LONG).show();
                            else
                                Toast.makeText(Batch6.this,"Data not Inserted please try again",Toast.LENGTH_LONG).show();
                        }
                }
        );
    }

    public void viewA() {
        btnviewAll.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Cursor res = myDb1.getAllData();
                        if(res.getCount() == 0) {
                            // show message
                            showMessage("Error","Nothing found");
                            return;
                        }

                        StringBuffer buffer = new StringBuffer();
                        while (res.moveToNext()) {
                            buffer.append("Id :"+ res.getString(0)+"\n");
                            buffer.append("Batch Number :"+ res.getString(1)+"\n");
                            buffer.append("Start  Date :"+ res.getString(2)+"\n");
                            buffer.append("Release Date :"+ res.getString(3)+"\n\n");
                            buffer.append("Origin :"+ res.getString(4)+"\n\n");
                            buffer.append("Total Batch :"+ res.getString(5)+"\n\n");
                            buffer.append("Average Weight :"+ res.getString(6)+"\n\n");
                            buffer.append("Room :"+ res.getString(7)+"\n\n");
                        }

                        // Show all data
                        showMessage("Data",buffer.toString());
                    }
                }
        );
    }

    public void showMessage(String title,String Message){
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    // @Override
   /* public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.s) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }*/
}