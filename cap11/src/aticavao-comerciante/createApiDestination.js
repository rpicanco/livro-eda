import { CreateApiDestinationCommand } from "@aws-sdk/client-eventbridge";
import { ebClient } from "./eventBridgeClient.js";

async function createApiDestination(input) {  
  
  const createApiDestinationInput = {  
    Name: input.name,
    Description: "",
    ConnectionArn: input.connectionArn,
    InvocationEndpoint: input.endpoint, 
    HttpMethod: "POST",
};

  try {

    const result = await ebClient.send(new CreateApiDestinationCommand(createApiDestinationInput));
    return result;
    
  } catch (err) {
    console.log("Error", err);
  }
};

export { createApiDestination };