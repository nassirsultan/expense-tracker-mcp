package com.nassir.expensetracker.tools;

import org.springframework.ai.tool.annotation.Tool;
import org.springframework.stereotype.Service;

@Service
public class PingTools {

    @Tool(description = "Returns 'pong'. Use to verify the server is reachable.")
    public String ping() {
        return "pong";
    }
}