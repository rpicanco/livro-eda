import { PutRuleCommand } from "@aws-sdk/client-eventbridge";
import { ebClient } from "./eventBridgeClient.js";

async function createRule(input) {   

  try {   

    const eventPattern = "{\"detail\": {\"merchantId\": [\"XXX\"]}}".replace("XXX", input.merchantId);

    const PutRuleCommandInput = {  
      Name: input.name,      
      State: "ENABLED",
      EventPattern: eventPattern,
    };

    const result = await ebClient.send(new PutRuleCommand(PutRuleCommandInput));
    return result;

  } catch (err) {
    console.log("Error", err);
  }
};

export { createRule };