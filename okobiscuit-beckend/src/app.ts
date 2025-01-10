import express, { Request, Response } from 'express';
import cors from 'cors';
import globalErrorHandler from './app/middlewares/globalErrorHandler';
import notFoundHandler from './app/middlewares/notFoundHandler';
import router from './app/routes';
const app = express();

// parser
app.use(express.json());
const corsOptions = {
  origin: ['http://localhost:5173', 'https://okobiscuit-admin.vercel.app'],
  credentials: true,
};

app.use(cors(corsOptions));

app.options('*', cors(corsOptions));

app.use((req, res, next) => {
  res.header('Access-Control-Allow-Origin', req.headers.origin);
  res.header('Access-Control-Allow-Methods', 'GET,PUT,POST,DELETE,OPTIONS');
  res.header(
    'Access-Control-Allow-Headers',
    'Content-Type, Authorization, Content-Length, X-Requested-With',
  );
  res.header('Access-Control-Allow-Credentials', 'true');

  // intercept OPTIONS method
  if ('OPTIONS' === req.method) {
    res.send(200);
  } else {
    next();
  }
});

// application routes
app.use('/api/v1', router);

//testing routes
const test = (req: Request, res: Response) => {
  const a = 'Okobiskuit, Running...!';

  res.send(a);
};
app.get('/', test);

//global error
app.use(globalErrorHandler);

//Not Found
app.use(notFoundHandler);

export default app;
