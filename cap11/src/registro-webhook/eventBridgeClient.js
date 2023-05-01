import { EventBridgeClient } from "@aws-sdk/client-eventbridge";

const REGION = process.env.AWS_REGION;
const ebClient = new EventBridgeClient({ region: REGION });
export { ebClient };