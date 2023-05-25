const express = require('express');
const bodyParser = require('body-parser');
const openai = require('openai');
const apiKey = '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';

openai.apiKey = apiKey;

const model = 'davinci';

const app = express();
app.use(bodyParser.json());

app.post('/ask', (req, res) => {
  const question = req.body.question;

  const prompt = `Q: ${question}
A:`;

  const params = {
    prompt: prompt,
    maxTokens: 1024,
    temperature: 0.5,
    n: 1,
    stop: '\n'
  };

  openai.complete(model, params)
    .then(response => {
      const answer = response.choices[0].text.trim();
      res.send(answer);
    })
    .catch(err => {
      console.error(err);
      res.status(500).send('An error occurred while generating the answer.');
    });
});

const port = 3000;
app.listen(port, () => {
  console.log(`Server running on port ${port}.`);
});
import { Configuration, OpenAIApi } from "openai";
const configuration = new Configuration({
    organization: "org-w6acCAJVKfYOvreaSXuqSDFy",
    apiKey: process.env.OPENAI_API_KEY,
});
const openai = new OpenAIApi(configuration);
const response = await openai.listEngines();