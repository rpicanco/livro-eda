import { PutTargetsCommand } from "@aws-sdk/client-eventbridge";
import { ebClient } from "./eventBridgeClient.js";
import { createRole } from "./createRole.js";

async function createTarget(input) {  

  try {

    const createRoleInput = {
      apiDestinationName: input.apiDestinationName,      
      merchantId: input.merchantId,
  };

    const roleArn = await createRole(createRoleInput);    

    const PutTargetsInput = {
      Rule: input.ruleName,
      Targets: [
          {
            Arn: input.apiDestinationArn,
            Id: input.merchantId + "-apidestination-target",
            RoleArn: roleArn,
            InputTransformer: { 
              InputPathsMap: { 
                "merchantId": "$.detail.merchantId",
                "orderId": "$.detail.orderId",
                "totalAmount": "$.detail.totalAmount",
                "status": "$.detail.status",
                "customer_id": "$.detail.customer.id",
                "customer_cpf": "$.detail.customer.cpf",
                "customer_first_name": "$.detail.customer.first_name",
                "customer_last_name": "$.detail.customer.last_name",
                "customer_email": "$.detail.customer.email",
                "customer_phone": "$.detail.customer.phone",
                "deliveryAddress_street": "$.detail.deliveryAddress.street",
                "deliveryAddress_number": "$.detail.deliveryAddress.number",
                "deliveryAddress_postalCode": "$.detail.deliveryAddress.postalCode",
                "deliveryAddress_city": "$.detail.deliveryAddress.city",
                "deliveryAddress_state": "$.detail.deliveryAddress.state",
              },
              InputTemplate: "{\"merchantId\": \"<merchantId>\",\"orderId\": \"<orderId>\",\"totalAmount\":\"<totalAmount>\",\"status\":\"<status>\",\"customer\":{\"id\":\"<customer_id>\",\"cpf\": \"<customer_cpf>\",\"first_name\":\"<customer_first_name>\",\"last_name\": \"<customer_last_name>\",\"email\": \"<customer_email>\",\"phone\": \"<customer_phone>\"},\"deliveryAddress\":{\"street\": \"<deliveryAddress_street>\",\"number\": \"<deliveryAddress_number>\",\"postalCode\": \"<deliveryAddress_postalCode>\",\"city\": \"<deliveryAddress_city>\",\"state\": \"<deliveryAddress_state>\"}}", 
            },
          },
      ]    
    };
    
  const result = await ebClient.send(new PutTargetsCommand(PutTargetsInput));
  return result;

  } catch (err) {
    console.log("Error", err);
  }
}

export { createTarget };