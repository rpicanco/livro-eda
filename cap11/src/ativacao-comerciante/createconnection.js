import { CreateConnectionCommand } from "@aws-sdk/client-eventbridge";
import { ebClient } from "./eventBridgeClient.js";

async function createConnection(input) {
  
  const CreateConnectionInput = {  
    Name: input.connectionName, 
    Description: "",
    AuthorizationType: "API_KEY", 
    AuthParameters: { 
        ApiKeyAuthParameters: { 
            ApiKeyName: "api_key", 
            ApiKeyValue: "1234", 
        },
    }
};

  try {
    
    const result = await ebClient.send(new CreateConnectionCommand(CreateConnectionInput));
    return result;

  } catch (err) {
    console.log("Error", err);
  }
};

export { createConnection };