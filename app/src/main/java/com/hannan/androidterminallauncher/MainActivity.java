public class MainActivity extends AppCompatActivity {

    private EditText commandInput;
    private TextView commandOutput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        commandInput = findViewById(R.id.command_input);
        commandOutput = findViewById(R.id.command_output);
        Button executeButton = findViewById(R.id.execute_button);

        executeButton.setOnClickListener(v -> {
            String command = commandInput.getText().toString();
            executeTermuxCommand(command);
        });
    }
    Button termuxApiButton = findViewById(R.id.termux_api_button);
    termuxApiButton.setOnClickListener(v -> {
        Intent intent = new Intent("com.termux.api.RUN_COMMAND");
        intent.setPackage("com.termux.api");
        intent.putExtra("com.termux.api.RUN_COMMAND_PATH", "/data/data/com.termux/files/usr/bin/bash");
        intent.putExtra("com.termux.api.RUN_COMMAND_ARGUMENTS", new String[]{"termux-battery-status"});
        startActivity(intent);
    });

    private void executeTermuxCommand(String command) {
        // Use an Intent to open Termux and run the command
        Intent intent = new Intent("com.termux.app.RUN_COMMAND");
        intent.setPackage("com.termux");
        intent.putExtra("com.termux.RUN_COMMAND_PATH", "/data/data/com.termux/files/usr/bin/bash");
        intent.putExtra("com.termux.RUN_COMMAND_ARGUMENTS", new String[]{command});
        startActivity(intent);
    }
}

